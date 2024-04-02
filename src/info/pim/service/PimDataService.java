package info.pim.service;

import info.pim.model.Contact;
import info.pim.model.Event;
import info.pim.model.Note;
import info.pim.model.Task;
import info.pim.util.SnowflakeIdWorker;
import info.pim.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * PIM data service
 */
public class PimDataService {
    /**
     * PIM file path for data storage
     */
    private static String imDataFilePath = "data" + File.separator + "data.pim";

    public static List<Note> notes = new ArrayList<>();
    public static List<Task> tasks = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();
    public static List<Contact> contacts = new ArrayList<>();

    public static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    /**
     * Load PIM data from file
     * @param path If empty, load from default location data/data.pim
     *
     */
    public static boolean loadPimData(String path) {
        if (!StringUtils.isEmpty(path)) {
            imDataFilePath = path;
        }
        try {
            File pimFile = new File(imDataFilePath);

            if (!pimFile.exists()) {
                if (!pimFile.getParentFile().exists()) {
                    pimFile.getParentFile().mkdirs();
                }
                pimFile.createNewFile();
                // Initialising data structures with an empty file
                savePimData();
            } else {
                FileInputStream fis = null;
                ObjectInputStream ois = null;
                fis = new FileInputStream(pimFile);
                ois = new ObjectInputStream(fis);
                HashMap<String, List> map = (HashMap<String, List>) ois.readObject();
                if (map != null) {
                    notes = map.getOrDefault("notes", new ArrayList());
                    tasks = map.getOrDefault("tasks", new ArrayList());
                    events = map.getOrDefault("events", new ArrayList());
                    contacts = map.getOrDefault("contacts", new ArrayList());
                }
                ois.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading PIM data!");
        }
        return false;
    }

    /**
     * Save PIM data to a file
     */
    private static void savePimData() {
        HashMap<String, List> map = new HashMap<>();
        map.put("notes", notes);
        map.put("tasks", tasks);
        map.put("events", events);
        map.put("contacts", contacts);

        File pimFile = new File(imDataFilePath);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pimFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading PIM data!");
        }
    }

    /**
     * Get Note by id
     */
    public static Note getNote(String id) {
        Optional<Note> optionalNote = notes.stream().filter(f -> f.getId().equals(id)).findFirst();
        return optionalNote.orElse(null);
    }

    /**
     * Save Note
     */
    public static void saveNote(Note note) {
        Optional<Note> optionalNote = notes.stream().filter(f -> f.getId().equals(note.getId())).findFirst();
        if (optionalNote.isPresent()) {
            Note noteUpdate = optionalNote.get();
            // Update data
            noteUpdate.copyData(note);
        } else {
            // Add data
            notes.add(note);
        }
        savePimData();
    }

    /**
     * Delete Note
     *
     * @param id id to be deleted
     */
    public static void deleteNote(String id) {
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note.getId().equals(id)) {
                notes.remove(i);
                savePimData();
                break;
            }
        }
    }

    /**
     * Get Task by id
     */
    public static Task getTask(String id) {
        Optional<Task> optionalTask = tasks.stream().filter(f -> f.getId().equals(id)).findFirst();
        return optionalTask.orElse(null);
    }

    /**
     * Save Task
     */
    public static void saveTask(Task task) {
        Optional<Task> optionalTask = tasks.stream().filter(f -> f.getId().equals(task.getId())).findFirst();
        if (optionalTask.isPresent()) {
            Task taskUpdate = optionalTask.get();
            // Update data
            taskUpdate.copyData(task);
        } else {
            // Add data
            tasks.add(task);
        }
        savePimData();
    }

    /**
     * Delete Task
     *
     * @param id id to be deleted
     */
    public static void deleteTask(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                tasks.remove(i);
                savePimData();
                break;
            }
        }
    }

    /**
     * Get Event by id
     */
    public static Event getEvent(String id) {
        Optional<Event> optionalEvent = events.stream().filter(f -> f.getId().equals(id)).findFirst();
        return optionalEvent.orElse(null);
    }

    /**
     * Save Event
     */
    public static void saveEvent(Event event) {
        Optional<Event> optionalEvent = events.stream().filter(f -> f.getId().equals(event.getId())).findFirst();
        if (optionalEvent.isPresent()) {
            Event eventUpdate = optionalEvent.get();
            // Update data
            eventUpdate.copyData(event);
        } else {
            // Add data
            events.add(event);
        }
        savePimData();
    }

    /**
     * Delete Event
     *
     * @param id id to be deleted
     */
    public static void deleteEvent(String id) {
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getId().equals(id)) {
                events.remove(i);
                savePimData();
                break;
            }
        }
    }

    /**
     * Get Contact by id
     */
    public static Contact getContact(String id) {
        Optional<Contact> optionalContact = contacts.stream().filter(f -> f.getId().equals(id)).findFirst();
        return optionalContact.orElse(null);
    }

    /**
     * Save Contact
     */
    public static void saveContact(Contact contact) {
        Optional<Contact> optionalContact = contacts.stream().filter(f -> f.getId().equals(contact.getId())).findFirst();
        if (optionalContact.isPresent()) {
            Contact contactUpdate = optionalContact.get();
            // Update data
            contactUpdate.copyData(contact);
        } else {
            // Add data
            contacts.add(contact);
        }
        savePimData();
    }

    /**
     * Delete Contact
     *
     * @param id id to be deleted
     */
    public static void deleteContact(String id) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getId().equals(id)) {
                contacts.remove(i);
                savePimData();
                break;
            }
        }
    }

    /**
     * Get all data
     */
    public static List<Object> getAllPir() {
        List<Object> result = new ArrayList<>();
        result.addAll(notes);
        result.addAll(tasks);
        result.addAll(events);
        result.addAll(contacts);
        return result;
    }

    /**
     * Get info by id
     */
    public static Object getPirById(String id) {
        Note note = getNote(id);
        if (note != null) {
            return note;
        }
        Task task = getTask(id);
        if (task != null) {
            return task;
        }
        Event event = getEvent(id);
        if (event != null) {
            return event;
        }
        Contact contact = getContact(id);
        if (contact != null) {
            return contact;
        }
        return null;
    }
}
