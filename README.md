## edfa3ly cart

#### Purpose

This test suite and test script are designed to test against edfa3ly cart feature on edfa3ly.com
> All test and bugs found under *documentations* folder

![Alt Text](https://drive.google.com/uc?export=view&id=1mEGo6_F7XPDORzIsFIMBgq_bVMFesKju)

#### Packages

+ data: data class for variables in data excel sheets
+ drivers: where chrome driver lives
+ pages: page class for pages under test. This is where web elements and their methods live
+ tests: test classes here are the files to run to trigger the framework
+ utils: helper code to slice strings and read data with apache poi

#### Tech & Tools:

+ Java
+ Maven
+ Apache POI
+ TestNG
+ Selenium
+ POM

#### How to run

+ Start by `` git clone https://github.com/EhabShaaban/edfa3ly``
+ Make sure you have Java installed
> If not please refer to: https://www.java.com/en/download/manual.jsp
+ Let all the dependencies to be downloaded locally when importing the project
+ In ``CartTest.java`` change system paths on Line ``[23, 45, 54, 67]`` to match your machine
+ Download ``org.apache.commons.io.FileUtils`` throw https://commons.apache.org/proper/commons-io/download_io.cgi
+ Screenshots of test will be generated under ``/test-output/snapshots``
+ TestNG report under ``/test-output/emailable-report.html`` with snaps of failures or defects attached inside
