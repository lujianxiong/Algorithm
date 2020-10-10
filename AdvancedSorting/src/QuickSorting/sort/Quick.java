package QuickSorting.sort;
//快速排序
public class Quick {
    //比较v元素是否小于w元素
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    //数组元素i和j交换位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //对数组内的元素进行排序
    public static void sort(Comparable[] a){
        int low = 0;
        int high = a.length-1;
        sort(a,low,high);
    }

    //对数组a中从索引low到high的元素进行排序
    public static void sort(Comparable[] a,int low,int high){
        //安全性校验
        if(high<=low)
            return;
        //需要对数组中low索引到high索引处的元素进行分组(左子组、右子组)；
        int partition = partition(a,low,high);  //调用这个函数进行分组，并返回分界值的索引(注意：是分界值位置变换后的索引)

        //让左子组有序    (左子组为从0开始到分界值索引前一个)
        sort(a,low,partition-1);

        //让右子组有序    (右子组为从分界值往后一个索引处开始到最后一个)
        sort(a,partition+1,high);
    }

    //对数组a中从索引low到索引high之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a,int low,int high){
        //确定分界值(就是首个元素)
        Comparable key = a[low];

        //定义两个指针，分别指向待切分元素的最小索引处 和 最大索引处的下一个位置；
        int left = low;
        int right = high+1;

        //切分
        while(true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            //当右指针所指的元素大于分界值，就循环
            while(less(key,a[--right])){  // "--"指的就是右指针往左移
                //如果往左移到最后一个还没有找到比分界值小的元素，那么就必须停止了
                if(right == low){
                    break;
                }
            }

            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            //当左指针所指的元素小于分界值，就循环；如果大就结束循环
            while(less(a[++left],key)){
                //如果右移到最后一个元素还没有找到比分界值大的元素，就必须停止。
                if(left == high){
                    break;
                }
            }

            //判断：left>=right，如果true，则扫描完毕，结束循环；如果false，则交换元素
            if(left >= right){
                break;
            }else{
                exch(a,left,right);
            }
        }
        //交换分界值
        exch(a,low,right);
        return right;   //分界值转换到right处了，因此返回分界值：right
    }

}

