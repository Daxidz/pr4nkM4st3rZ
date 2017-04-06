# pr4nkM4st3rZ

**pr4nkM4st3rZ** is a project made for HEIG-VD by Lucas ELISEI ([@faku99](https://github.com/faku99)) and David TRUAN ([@Daxidz](https://github.com/Daxidz)).

It's a simple Java application used for sending forged emails to groups of persons. The user can define a list of victims in a file and several messages to send.

# Table of contents

1. [General informations](#General)
    1. [Installation](#Installation)
        1. [Maven installation](#Maven-Installation)
        2. [Maven-free installation](#Other-Installation)
    2. [Running the program](#Running)
    3. [Properties file](#Properties)
    4. [Victims list](#VictimsList)
    5. [Email messages](#Messages)
2. [Technical informations](#Technical)
    1. [Classes diagram](#UML)
    2. [Using a mock SMTP server](#SMTP)
        1. [Installation steps](#STMP-Installation)

# <a name="General"></a>General informations

## <a name="Installation"></a>Installation

There are two ways for installing **pr4nkM4st3rZ**:

### <a name="Maven-Installation"></a>Maven installation

If you have **Maven** installed on your computer, simply clone this repository and execute the following command:

    mvn clean install

The compiled `.jar` file is now available at the location `target/pr4nkM4st3rZ-1.0.jar`. See the [Running](#Running) section for running the program.

### <a name="Other-Installation"></a>Maven-free installation

Simply download the latest available **pr4nkM4st3rZ** release by clicking on [this link](https://github.com/faku99/pr4nkM4st3rZ/releases/latest). It will download a `.zip` file. Extract and follow the [Running](#Running) instructions.

## <a name="Running"></a>Running the program

**Important!**

Before running the application, please make sure to check that the file `config.properties` contains the right informations for your use. More informations about the `config.properties` can be found at the [Properties file](#Properties) section.

When you did, at the application startup, you must provide how many groups of victims to create. **Beware**: In every group of victims, there should be **one** sender and at least **two** recipients.

To run the program, execute the following command:

    java -jar pr4nkM4st3rZ.jar <number_of_groups>

where `<number_of_groups>` is how many groups of victims you want to create. If there aren't enough victims to fill the groups number, then the program will automatically create the maximum possible amount of groups according to the victims list.

## <a name="Properties"></a>Properties file

The properties file is located at the path `config.properties`. The file name **cannot** be changed. This file contains several variables. Each are explained below:

 Variable | Default value | Description
:---:|:---:|------
`SMTP_ADDRESS` | `localhost`| The address of the SMTP server to use.
`SMTP_PORT` | `25`| The port of the SMTP server to use.
`VICTIMS_LIST` | `victims.txt` | The path of the file which contains the [victims list](#VictimsList).
`MSGS_DIR` | `messages/` | The path of the folder containing [emails messages](#Messages).

## <a name="VictimsList"></a>Victims list

To define a list of victims, simply edit the file containing the victims list (see [Properties](#Properties) for more informations) with an email address per line.

Example:

    victim1@domain.net
    victim2@domain.net

## <a name="Messages"></a>Email messages

Several body messages can be used for sending the emails. Each file present in the `MSGS_DIR` (see [Properties](#Properties) for more informations) represents a body message.

A message is composed of a *subject* and a *body*. The first line of the file is interpreted as the subject and the rest as the body.

Example:

    Hey I'm the subject of the email!
    And I'm the body cuz I'm after the first line.

# <a name="Technical"></a>Technical informations

## <a name="UML"></a>Classes diagram

![Classes diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/faku99/pr4nkM4st3rZ/master/figures/classes.plantuml)  

## <a name="SMTP"></a>Using a mock SMTP server

If you want to try **pr4nkM4st3rZ** without getting kicked out of your company or just to see if you set the properties right, you can use a **mock SMTP server**. Its goal is to simulate a SMTP server for tests purpose.  
[Here](https://github.com/tweakers-dev/MockMock) is the one we used to test our application while developping it. It is a simple one with a network interface available by your browser.

### <a name="STMP-Installation"></a>Installation steps

* Clone the repo.
* Replace line 51 of the `pom.xml` by `<groupId>com.jolira</groupId>`.
* It is a **Maven** project so you will need [Maven](https://maven.apache.org/download.cgi) to build it. Once you have **Maven**, run the command `mvn clean install` in the `MockMock` folder.
* You can now execute the `.jar` by typing `java -jar MockMock-1.4.0.one-jar.jar`. It will launch the mock SMTP server using `localhost` as the server and using the port `25` for SMTP and `8282` for the web-interface. If you want to change these ports you can use the `-p` for the SMTP port and `-h` for the web-interface port.
* Once it is launched and loaded you can access it on `http://localhost:theportyousethere/`.
