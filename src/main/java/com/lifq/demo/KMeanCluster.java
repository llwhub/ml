package com.lifq.demo;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * desc ：聚类Kmeans
 * author ：lfq
 * date ：2019-08-27 14:22
 * </pre>
 */

public class KMeanCluster {
    public static void main(String[] args) throws IOException {
        // 加载数据
        Dataset dataSet = FileHandler.loadDataset(new File("src/main/resources/zscoreddata.csv"),-1,",");
        //分成5类
        KMeans km = new KMeans(2);
        //分类数据
        Dataset[] clusters  = km.cluster(dataSet);

        //分类大小
        System.out.println(clusters.length);
        //打印分类数据
        for(Dataset res:clusters){
            System.out.println(res.noAttributes());
        }
    }
}
