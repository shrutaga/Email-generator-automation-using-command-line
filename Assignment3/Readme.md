Readme

# Insurance Company Email and Letter Automation

Insurance Company email and letter automation is a tool for dealing with the situation where the companu needs to sendout a widespread notification/alert messages to all its customers/users.

## Installation

There is no installation required for this tool. It is a command line tool and is platform independent.

## Usage

To generate email-

-create a template email
or the provided template can be used/modified as per the requirement

-create a csv file
A csv file needs to be created with the communication deatils of all the intended recepients/customers
A sample csv file is provided.

-specify a directory path
An output directory/folder path to be specified where the generated emails can be stored for easy access.


To generate letter-

-create a template letter
or the provided template can be used/modified as per the requirement

-create a csv file
A csv file needs to be created with the communication deatils of all the intended recepients/customers
A sample csv file is provided.

-specify a directory path
An output directory/folder path to be specified where the generated emails can be stored for easy access.

## Usage Command

To use the command, follow the below Steps.

Step 1 : Compile the code using javac
Step 2. Run the main class `CliTester` using java. 
	
	Example: java CliTester <command_name> <Argumenets for the command>

There are two commands supported viz, email command(to generate the email from the tempalte and csv) and the letter command(to generate the letter from the tempalte and csv)

Step 3: To generate emails refer the below command.

java CliTester --email --email-template <email-template.txt> --output-dir <emails> --csv-file <customer.csv>

Step 4: To generate letters refer the below command.
java CliTester --letter --letter-template letter-template.txt --output-dir emails --csv-file customer.csv

