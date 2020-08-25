# tdd automation framework
tdd automation framework structured in pom to resgiter users on website. 
#### packages:
<ul>
<li>data: data class for header variables in data excel sheets</li>
<li>drivers: where chrome driver lives</li>
<li>pages: page class for pages under test. This is where web elements and it's methods live</li>
<li>tests: test classes here are the files to run to trigger the framework</li>
<li>utils: helper code to slice strings and read data with apache poi</li>
</ul>

#### tech & tools:
<ul>
  <li>Java</li>
  <li>Maven</li>
  <li>Apache POI</li>
  <li>TestNG</li>
  <li>Selenium</li>
  <li>POM</l>
</ul>


<!-- ![Alt Text](https://media.giphy.com/media/vFKqnCdLPNOKc/giphy.gif)-->
![Alt Text](https://drive.google.com/uc?export=view&id=1tNtLrTDfkZwa1F2KQrpInU8Xu6mERVma)

#### Notes:
<ul>
  <li>change directories to match with your machine</li>
  <li>org.apache.commons.io.FileUtils download throw https://commons.apache.org/proper/commons-io/download_io.cgi</li> 
  <li>snapshoots will be generated under /test-output/snapshots</li>
  <li> testng report under /test-output/emailable-report.html with snaps of failures or defects attached inside</li>
  <li> make sure to change cell type of new inserted data into excel sheet to 'text'</li>
</ul>
