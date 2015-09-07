package com.userFAQ.userQuerySearch;

import java.util.ArrayList;

public class BestRelatedQueriesIndexes {
	public int[] getIndexes(String query,ArrayList<int[]> arr,int abs){
		return myFunc(query,arr,10);
	}
	
	private static int[] myFunc(String str,ArrayList<int[]> list,int totalNumberOfQuestion){  
	        int[][] tempArr=new int[totalNumberOfQuestion][2];
	        for(int i=0;i<totalNumberOfQuestion;i++)tempArr[i][0]=i;
	        
	        int[] arr1;
	        
	        for(int i=0;i<list.size();i++){
	            arr1=list.get(i);
	            if(arr1!=null){
	                for(int j=0;j<arr1.length;j++){
	                   tempArr[arr1[j]][1]++;
	                }
	            }
	        }
	        
	        for(int i=0;i<totalNumberOfQuestion;i++){
	            int max=i;
	            for(int j=i;j<totalNumberOfQuestion;j++){
	                if(tempArr[max][1]<tempArr[j][1]){
	                    max=j;
	                }
	            }
	            int temp1=tempArr[max][0],temp2=tempArr[max][1];
	            tempArr[max][0]=tempArr[i][0];
	            tempArr[max][1]=tempArr[i][1];
	            tempArr[i][0]=temp1;
	            tempArr[i][1]=temp2;
	        }
	        
	        ArrayList<Integer> sd=new ArrayList<Integer>();
	        for(int i=0;i<totalNumberOfQuestion;i++){
	            if(tempArr[i][1]==0)break;
	            sd.add(tempArr[i][0]);
	        }
	        
	        
	        int[] arr=new int[sd.size()];
	        for(int i=0;i<arr.length;i++){
	            arr[i]=sd.get(i);
	        }
	        return arr;
	    }
	
	
	
}
