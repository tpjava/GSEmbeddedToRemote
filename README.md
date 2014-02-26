<h1>Gigaspace Embedded to Remote demo</h1>
<p>
<h2>How to run locally</h2>
<p>
Running the MainClass will init an embedded GS instance and load in 10K random quotes.
<p>
Using gs-ui.sh you can monitor this space.
<p>
Start up a separate GS process from the command line using:
<p>
NIC_ADDR=127.0.0.1 gs-agent.sh gsa.global.lus 0 gsa.lus 1
<p>
You can then start a remote replicated instance using:
<p>
gsInstance.sh "/./embeddedRemoteSpace?cluster_schema=sync_replicated&total_members=2&id=2"
<p>
You should now see two spaces in the UI both with the same data.
<p>
NOTE:
In the project pom.xml file change the <gsVersion> to reflect your local version.
