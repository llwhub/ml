package com.lifq.demo;

import jsat.SimpleDataSet;
import jsat.classifiers.DataPoint;
import jsat.clustering.kmeans.KMeans;
import jsat.clustering.kmeans.NaiveKMeans;
import jsat.clustering.kmeans.XMeans;
import jsat.io.CSV;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * desc ：聚类Kmeans
 * author ：lfq
 * date ：2019-08-27 14:22
 * </pre>
 */

public class KMeanClusterJSAT {
    public static void main(String[] args) throws IOException {
        // 加载数据
        Set<Integer> catCols = new HashSet<Integer>(Arrays.asList(0,1,2,3,4));
        SimpleDataSet simpleDataSet= CSV.read(new FileReader(new File("src/main/resources/zscoreddata.csv")),0,catCols);
        XMeans xMeans =new XMeans();
        xMeans.setMinClusterSize(5);
        //分类数据

        List<List<DataPoint>> dataList = xMeans.cluster(simpleDataSet,5);
        for(List<DataPoint> list:dataList){
            System.out.println(list);
        }
    }
}
