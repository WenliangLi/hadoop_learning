package org.datastruct.sort;

/**
 * 类或接口的功能说明
 *
 * @author liwenliang
 * @Date: 2017年07月24日 上午10:16:00
 * @History :
 * @Date: 2017年07月24日 上午10:16:00
 * @author: berchina-liwenliang
 * @Desc: 修改目的和修改方法
 **/
public class MergeSort {

    public static void main(String args[]) throws Exception {
        int arr[] = {1,9,4,2,7,6};
        int l = 0;
        int r = 5;
//        merge(arr,0,3,5);
        mergeSort(arr,l,r);
        System.out.println("#####");
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }


    public static void mergeSort(int arr[],int l,int r) {
        if(l==r) {
            return;
        }else {
            int m = (l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m+1,r);
        }
    }

    public static void merge(int arr[],int l,int m,int r) {
        int left_size = m-l;
        int right_size = r-m+1;
        int[] left_arr = new int[m-l];
        int[] right_arr = new int[r-m+1];
        System.out.println("======");
        for(int i=0;i<left_size;i++) {
            left_arr[i] = arr[i+l];
            System.out.println(left_arr[i]);
        }
        System.out.println("======");
        for (int i=0;i<right_size;i++) {
            right_arr[i] = arr[i+m];
            System.out.println(right_arr[i]);
        }

        int i =0,j=0,k=l;
        while (i<left_size&&j<right_size) {
            if(left_arr[i]<right_arr[j]) {
                arr[k] = left_arr[i];
                k++;
                i++;
            }else {
                arr[k] = right_arr[j];
                k++;
                j++;
            }
        }
        if(i<left_size) {
            for(;k<=r;k++) {
                arr[k] = left_arr[i];
                i++;
            }
        }
        if(j<right_size) {
            for(;k<=r;k++) {
                arr[k]  = right_arr[j];
                j++;
            }
        }

    }
}
