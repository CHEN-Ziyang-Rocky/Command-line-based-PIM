# Overview
The PIM system implements comprehensive management functions for personal information records (PIR), supporting PIR types including notes, tasks, events, and contacts. Users shall load the xx.pim file to check their input PIRs.

## 1. System startup and loading
➢ Method 1: The default startup method of the system is to load the data.pim file under the subdirectory data in the current directory of the system (where pim. jar is located), with a relative path of (data/data.pim). If the data.pim file does not exist, it will be created as.java -jar pim.jar

➢ Method 2: Add the pim file directory parameter after the system startup command. Starting this method will use the data file with this parameter to load. If the file does not exist, it will be created.java -jar pim.jar data/data_new.pim
