package MergeSorting.sort;
//归并排序算法
public class Merge {
    private static Comparable[] assist;  //归并排序需要用到的辅助数组

    //比较v元素是否小于w元素
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<=0;
    }

    //数组元素i和j交换位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
        //1,初始化辅助数组assist
        assist =new Comparable[a.length];
        //2.定义一个low变量和high变量，分别记录数组中最小的索引和最大的索引
        int low = 0;
        int high = a.length-1;
        //3.调用sort重载方法完成数组a中从索引low到high的元素的排序
        sort(a,low,high);
    }

    //对数组a中从low到high的元素进行排序
    private static void sort(Comparable[] a,int low,int high){
        //做安全性校验
        if(high<=low){
            return;  //什么也不做
        }

        //1.对low到high之间的数据分为两个组
        int mid = low+(high-low)/2;   //mid为low和high中间数的索引
        // 算出low和high索引的差值的一半再加上low就是mid的索引，比如：5，9 mid=7，5-7是一组，8-9是一组

        //2.分别对每一组数据进行排序 1
        sort(a,low,mid);  //递归调用sort方法，直到low=mid，停止递归，上面的安全性校验就起到作用了
        sort(a,mid+1,high);

        //3.再把两个组中的数据进行归并
        merge(a,low,mid,high);

    }

    //对数组中，从low到mid为一组，从mid到high为一组，对这两组数据进行归并
    public static void merge(Comparable[] a,int low,int mid,int high){
        //1.定义三个指针
        int i = low;
        int p1 = low;
        int p2 = mid+1;

        //2.遍历：移动p1指针和p2指针，比较对应索引处的值，找出小的那个放到辅助数组的对应索引处；只要有一个指针把对应数组里元素指完了，遍历结束。
        while(p1<=mid && p2<=high){
            //比较对应索引处的值
            if(less(a[p1],a[p2])){
                //如果p1小于等于p2，把p1指向的元素放到辅助数组中
                //注意：这里的less函数中的等于确保了归并排序算法的稳定性，如果左子组中的数=右子组中的数，那么将左子组中的p1先放进辅助数组
                assist[i++] = a[p1++]; //放完元素后，拿出元素的指针和辅助数组的指针
            }else{
                assist[i++] = a[p2++];
            }
        }

        //3.遍历：如果p1指针没有走完，那么顺序移动p1指针把对应的元素放到辅助数组的对应索引处
        while(p1<=mid){
            assist[i++] = a[p1++];
        }
        //4.遍历：如果p2指针没有走完，那么顺序移动p2指针把对应的元素放到辅助数组的对应索引处
        while(p2<=high){
            assist[i++] = a[p2++];
        }

        //5.把辅助数组中的元素拷贝到原数组中
        for(int index=low;index<=high;index++){
            a[index] = assist[index];
        }
    }
}
