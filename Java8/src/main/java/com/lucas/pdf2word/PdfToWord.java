package com.lucas.pdf2word;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

public class PdfToWord {
    public static void main(String[] args) {

        //创建一个 PdfDocument 对象
        PdfDocument doc = new PdfDocument();
        //加载 PDF 文件
        doc.loadFromFile("E:\\image\\003.pdf");

        long start = System.currentTimeMillis();
        //将PDF转换为Doc格式文件并保存，当前工程目录级别下
        doc.saveToFile("E:\\image\\003.doc", FileFormat.DOC);
        long end = System.currentTimeMillis();
        System.out.println("pdf转doc耗时："+(end-start)/1000);
        //将PDF转换为Docx格式文件并保存，同目录级别下
        long start1 = System.currentTimeMillis();
        doc.saveToFile("E:\\image\\003.docx", FileFormat.DOCX);
        long end1 = System.currentTimeMillis();
        System.out.println("pdf转docx耗时："+(end1-start1)/1000);
        doc.close();

        System.out.println("PDF转word成功");
    }
}
