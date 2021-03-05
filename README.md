# Analysis-of-Stock-Market-using-Hadoop-Map-Reduce
 Analysis of Stock Market using Hadoop Map Reduce
 
# How to Run the Program ?

First install Hadoop in you system. Follow the steps to install 

https://phoenixnap.com/kb/install-hadoop-ubuntu

# Then start executing given commands

cd hadoop-3.2.2/sbin

./start-dfs.sh

./start-yarn.sh

jps

export HADOOP_CLASSPATH=$(hadoop classpath)

echo $HADOOP_CLASSPATH

# Create and Delete folders in HDFS

hadoop fs -mkdir /WordCountTutorial

hadoop fs -mkdir /WordCountTutorial/Input

hadoop dfs -rmr -skipTrash /user/*

# Put data in hdfs

$HADOOP_HOME/bin/hdfs dfs -put /home/hdoop/Desktop/A/input-dataset /

hadoop fs -put '/home/hdoop/Desktop/A/input_data/input.txt' /WordCountTutorial/Input

# Compile Java Files

cd /home/hdoop/Desktop/A

javac -classpath ${HADOOP_CLASSPATH} -d '/home/hdoop/Desktop/A/tutorial_classes' '/home/hdoop/Desktop/A/WordCount.java'

javac src/*.java -cp $(hadoop classpath)

# Create Jar File

Keep all .class file in "classes" folder

jar -cvf firstTutorial.jar -C tutorial_classes/ .

# Perform the Map Reduce in input data through Jar file

hadoop jar '/home/hdoop/Desktop/A/firstTutorial.jar' WordCount /WordCountTutorial/Input /WordCountTutorial/Output

hadoop jar stock.jar MainStockAnalysis  /stock_input   /stock_output

# See the output of the Program

hadoop dfs -cat /WordCountTutorial/Output2/*

hadoop fs -cat /WordCountTutorial/output-dataset100/part-r-00000 | head

# Close the Hadoop

cd hadoop-3.2.2/sbin

./stop-all.sh

-------------------------------------------------------------------------------------------------------
 Written by -  PRANAB NANDY 
 ------------------------------------------------------------------------------------------------------


