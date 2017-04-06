# pr4nkM4st3rZ

**pr4nkM4st3rZ** is a project made for HEIG-VD by Lucas ELISEI ([@faku99](https://github.com/faku99)) and David TRUAN ([@Daxidz](https://github.com/Daxidz)).

It's a simple Java application used for sending forged emails to groups of persons. The user can define a list of victims in a file and several messages to send.

# General informations

Before launching the application, please be sure to check that the file `prank.properties` contains the right informations for your use.

When you did, at the application startup, you must provide how many groups of victims to create. **Beware**: In every group of victims, there should be **one** sender and at least **two** recipients.

## <a name="Properties"></a>Properties file

The properties file is located at the path `prank.properties`. The file name **cannot** be changed. This file contains several variables. Each are explained below:

 Variable | Default value | Description
:---:|:---:|------
`SMTP_ADDRESS` | `localhost`| The address of the SMTP server to use.
`SMTP_PORT` | `25`| The port of the SMTP server to use.
`VICTIMS_LIST` | `victims.txt` | The path of the file which contains the [victims list](#VictimsList).
`BODIES_DIR` | `messages/` | The path of the folder containing [bodies](#Bodies) for emails.

## <a name="VictimsList"></a>Victims list

To define a list of victims, simply edit the file containing the victims list (see [Properties](#Properties) for more informations) with an email address per line.

Example:

    victim1@domain.net
    victim2@domain.net

## <a name="Bodies"></a>Body messages

Several body messages can be used for sending the emails. Each file present in the `BODIES_DIR` (see [Properties](#Properties) for more informations) represents a body message.

A message is composed of a *subject* and a *body*. The first line of the file is interpreted as the subject and the rest as the body.

Example:

    Hey I'm the subject of the email!
    And I'm the body cuz I'm after the first line.

# Technical informations

## Classes diagram

![Classes diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/faku99/pr4nkM4st3rZ/master/figures/classes.plantuml)  


## Use of a mock SMTP server

If you want to try **pr4nkM4st3rZ** without getting kicked out of your company or just to see if you set the properties right, you can use a **mock SMTP server**. Its goal is to simulate a SMTP server for tests purpose.  
[Here](https://github.com/tweakers-dev/MockMock) is the one we used to test our application while developping it. It is a simple one with a network interface available by your browser.
### Installation steps
* Clone the repo.
* Replace line 51 of the `pom.xml` by `<groupId>com.jolira</groupId>`.
* It is a **Maven** project so you will need [Maven](https://maven.apache.org/download.cgi) to build it. Once you have **Maven**, run the command `mvn clean install` in the `MockMock` folder.
* You can now execute the `.jar` by typing `java -jar MockMock-1.4.0.one-jar.jar`. It will launch the mock SMTP server using `localhost` as the server and using the port `25` for SMTP and `8282` for the web-interface. If you want to change these ports you can use the `-p` for the SMTP port and `-h` for the web-interface port.
* Once it is lauched and loaded you can access it on `http://localhost:theportyousethere/`.
