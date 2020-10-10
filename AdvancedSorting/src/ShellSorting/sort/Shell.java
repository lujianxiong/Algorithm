package ShellSorting.sort;
//希尔排序
public class Shell {
    //第一个函数：对数组a中的元素进行排序
    public static void sort(Comparable[] a){
        //1.根据a的长度确定增长量h 的初始值；
        int h = 1;
        while(h<a.length/2){
            h=h*2+1;
        }
        //2.希尔排序；
        while(h>=1){
            //排序
            //2.1 首先找到待插入的元素
            //假设每个分组的第一个元素已排好，从每组第二个元素开始与前面第一个待插入的元素的索引其实就是h的值
            for(int i=h;i<a.length;i++){
                //2.2把待插入的元素插入到有序数列中
                for(int j=i;j>=h;j-=h){
                    //待插入的元素是a[j]，比较a[j]和a[j-h],
                    //如果j-h大，则交换；如果j大，那么就找到了a[j]应该放的位置，结束循环
                    if(greater(a[j-h],a[j])){
                        //交换元素
                        exch(a,j-h,j);
                    }else{
                        //带插入元素已经找到了合适的位置，结束循环；
                        break;
                    }
                }
            }

            //减少h的值
            h = h/2;
        }

    }

    //第二个函数：比较元素v是否大于w
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    //第三个元素：数组元素i与j交换位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
