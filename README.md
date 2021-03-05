# Analysis-of-Stock-Market-using-Hadoop-Map-Reduce
 Analysis of Stock Market using Hadoop Map Reduce
 
# How to Run the Program ?

cd hadoop-3.2.2/sbin

./start-dfs.sh

./start-yarn.sh

jps

export HADOOP_CLASSPATH=$(hadoop classpath)

echo $HADOOP_CLASSPATH

# Create and Delete folder in HDFS

hadoop fs -mkdir /WordCountTutorial

hadoop fs -mkdir /WordCountTutorial/Input

hadoop dfs -rmr -skipTrash /user/*
