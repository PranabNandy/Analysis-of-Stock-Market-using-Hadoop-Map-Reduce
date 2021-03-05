# Analysis-of-Stock-Market-using-Hadoop-Map-Reduce
 Analysis of Stock Market using Hadoop Map Reduce
 
# How to Run the Program ?

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

javac -classpath ${HADOOP_CLASSPATH} -d '/home/hdoop/Desktop/A/tutorial_classes' '/home/hdoop/Desktop/A/WordCount.java'
