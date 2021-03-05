import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MainStockAnalysis {

	public static void main(String[] args) throws Exception {		
		long start = new Date().getTime();		
		
	     Job job = Job.getInstance();
	     job.setJarByClass(MapReduceStage1.class);
	     
	     Job job2 = Job.getInstance();
	     job2.setJarByClass(MapReduceStage2.class);
	     
	     Job job3 = Job.getInstance();
	     job3.setJarByClass(MapReduceStage3.class);
	     
		System.out.println("\n**********Stock_Analysis_Hadoop_MapReduce-> Start**********\n");

		job.setJarByClass(MapReduceStage1.class);
		job.setMapperClass(MapReduceStage1.Map1.class);
		job.setReducerClass(MapReduceStage1.Reducer1.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path("Intermediate1"));
		
		job.waitForCompletion(true);
		
		
		job2.setJarByClass(MapReduceStage2.class);
		job2.setMapperClass(MapReduceStage2.Map2.class);
		job2.setReducerClass(MapReduceStage2.Reducer2.class);

		job2.setMapOutputKeyClass(Text.class);
		job2.setMapOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job2, new Path("Intermediate1"));
		FileOutputFormat.setOutputPath(job2, new Path("Intermediate2"));
		
		job2.waitForCompletion(true);
		
		
	    long mapperCounter = job2.getCounters().findCounter(MapReduceStage2.TestCounters.TEST).getValue();
	    Configuration conf = job3.getConfiguration();
	    conf.set("NoOfStocks",String.valueOf(mapperCounter));
	    
	    
		job3.setJarByClass(MapReduceStage3.class);
		job3.setMapperClass(MapReduceStage3.Map3.class);
		job3.setReducerClass(MapReduceStage3.Reducer3.class);

		job3.setMapOutputKeyClass(DoubleWritable.class);
		job3.setMapOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job3, new Path("Intermediate2"));
		FileOutputFormat.setOutputPath(job3, new Path(args[1]));
		
		boolean status = job3.waitForCompletion(true);
		if (status == true) {
			long end = new Date().getTime();
			System.out.println("\nJob took " + (end-start)/1000 + "seconds\n");
		}
		System.out.println("\n**********Stock_Analysis_Hadoop_MapReduce-> End**********\n");		
	}
}