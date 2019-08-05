import java.util.HashMap;
import java.util.Map;

/*
-Xms512m
-Xmx512m
-Xlog:gc=debug:file=./hw05-garbage-collection/logs/gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=./hw05-garbage-collection/logs/dump/
-XX:+UseG1GC

https://gceasy.io - GC Log Analyzer

Throughput - Percentage of time spent in processing real transactions vs time spent in GC activity. Higher percentage is
a good indication that GC overhead is low. One should aim for high throughput.

1. G1
Duration: 1 min 47 sec 959 ms

Generation	              |  Allocated  |	Peak
Young Generation	      |  36 mb	    |   25.00 mb
Old Generation	          |  476 mb	    |  447.00 mb
Humongous	              |  n/a	    |   98.00 mb
Meta Space	              |  1.01 gb	|   13.44 mb
Young + Old + Meta space  |	 1.51 gb	|  525.44 mb

Throughput  : 62.126%
Avg Pause GC Time 	730 ms
Max Pause GC Time 	2 sec 780 ms

Object stats
Total created bytes 	539 mb
Total promoted bytes 	506 mb
Avg creation rate 	    4.99 mb/sec
Avg promotion rate 	    4.69 mb/sec

What events caused the GCs, how much time it consumed?

Cause	                    Count	Avg Time	Max Time	    Total Time	        Time %
Others	                    10	      n/a	    n/a	            41 sec 206 ms	    50.2%
G1 Evacuation Pause 	    52	      782 ms	2 sec 780 ms	40 sec 670 ms	    49.55%
G1 Humongous Allocation 	1	      200 ms	200 ms	        200 ms	            0.24%
Total	                    63	      n/a	    n/a	            1 min 22 sec 76 ms	99.99%

2. Concurrent Mark Sweep
Duration: 4 min 59 sec 666 ms

Generation	                Allocated 	Peak
Young Generation	        153.56 mb	153.56 mb
Old Generation	            341.38 mb	341.38 mb
Meta Space	                1.01 gb	     13.41 mb
Young + Old + Meta space	1.5 gb	    507.41 mb

Throughput  : 42.159%
Avg Pause GC Time 	1 sec 825 ms
Max Pause GC Time 	3 sec 920 ms

Object Stats
Total created bytes 	356 mb
Total promoted bytes 	382.41 mb
Avg creation rate 	    1.19 mb/sec
Avg promotion rate 	    1.28 mb/sec

Cause	                        Count	Avg Time	    Max Time	    Total Time	            Time %
Full GC - Allocation Failure 	79	    1 sec 963 ms	3 sec 920 ms	2 min 35 sec 100 ms	    82.32%
Others	                        23	    n/a	            n/a	            24 sec 500 ms	        13.00%
Allocation Failure 	            5	    1 sec 762 ms	2 sec 990 ms	8 sec 810 ms	         4.68%
Total	                        107	    n/a	            n/a	            3 min 8 sec 410 ms	   100.00%

3. ParallelGC

Duration: 10 min 12 sec 895 ms

Generation	                Allocated 	Peak
Young Generation	        149.5 mb	149.48 mb
Old Generation	            341.5 mb	322.61 mb
Meta Space	                1.01 gb	     13.24 mb
Young + Old + Meta space	1.49 gb	    464.24 mb

Throughput  : 6.924%
Avg Pause GC Time 	1 sec 186 ms
Max Pause GC Time 	4 sec 760 ms

Object Stats
Total created bytes 	528 mb
Total promoted bytes 	303.97 mb
Avg creation rate 	    882 kb/sec
Avg promotion rate 	    507 kb/sec

Cause	            Count	Avg Time	    Max Time	    Total Time	            Time %
Ergonomics 	        479	    1 sec 188 ms	4 sec 760 ms	9 min 29 sec 60 ms	     99.75%
Allocation Failure 	3	    467 ms	        720 ms	              1 sec 400 ms	      0.25%
Others	            n/a	    n/a	            n/a	                     0.0610 ms	      0.00%
Total	            482	    n/a	            n/a	            9 min 30 sec 460 ms	    100.00%

-------------------------------------------------------------------------------
Summary.

Parallel: у данного сборщика было больше всего запусков сборок, несмотря на то, что приложение так и не свалилось с ООМ,
он показал наименьшую пропускную способность. Средняя продолжительность пауз меньше, чем у CMS, но больше, чем у G1. Но
этот показатель нивелируется малой пропускной способностью - среднее время паузы меньше, но из-за наибольшего кол-ва
запусков GC, общее время работы сборщика самое продолжительное.

CMS: показал наибольшее среднее время сборки GC, но самих сборок было гораздо меньше, чем у Parallel. Пропускная
способность меньше, чем у G1, но больше, чем у Parallel.

G1: Считаю G1 победителем -  наибольшая пропускная способность, меньше всего пауз, наименьшее среднее время паузы сборки
мусора, меньше всего запусков GC.

 */


/**
 * @author V. Zinchenko
 */
public class MemoryLeakDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<Person, Integer> map = new HashMap<>();
        for (int i = 0; i < 500; i++) {

            for (int j = 0; j < 100_000; j++) {
                map.put(new Person("John Doe"), 1);
                if (i > 70 && j % 1000 == 0) {
                    System.out.println("j = " + j);
                    System.out.println("map size = " + map.size());
                }
            }
            Thread.sleep(500);
            System.out.println("i = " + i);
            System.out.println("Map size:" + map.size());
        }

        System.out.println("Map size:" + map.size());
    }
}
