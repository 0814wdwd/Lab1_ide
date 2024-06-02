package cn.hit.sw.entity; // 包声明

import org.graphstream.graph.Graph; // 导入GraphStream的Graph接口
import org.graphstream.graph.implementations.SingleGraph; // 导入GraphStream的SingleGraph类，用于创建单一图
import org.graphstream.ui.swing_viewer.SwingViewer; // 导入SwingViewer，用于在Swing中显示图
import org.graphstream.ui.view.Viewer; // 导入Viewer，用于管理图的显示

import java.awt.*; // 导入AWT库，用于图形和界面元素

// 定义一个名为MyGraph的类，继承自SingleGraph
public class MyGraph extends SingleGraph {
    // 带有详细参数的构造方法
    public MyGraph(String id, boolean strictChecking, boolean autoCreate, int initialNodeCapacity, int initialEdgeCapacity) {
        super(id, strictChecking, autoCreate, initialNodeCapacity, initialEdgeCapacity); // 调用父类的构造方法
    }

    // 带有部分参数的构造方法
    public MyGraph(String id, boolean strictChecking, boolean autoCreate) {
        super(id, strictChecking, autoCreate); // 调用父类的构造方法
    }

    // 最简单的构造方法，只需要图的ID
    public MyGraph(String id) {
        super(id); // 调用父类的构造方法
    }

    // 自定义的方法用于显示图
    public void myDisplay(Graph graph) {
        // 设置图形样式
        graph.setAttribute("ui.stylesheet",
                "node {" +
                        "   fill-color: black;" +
                        "   size: 20px;" +
                        "   text-alignment: above;" +
                        "   text-size: 20;" +
                        "   text-color: black;" +
                        "   text-style: bold;" +
                        "   text-alignment: under;" +
                        "}" +
                        "edge {" +
                        "   fill-color: black;" +
                        "   size: 3px;" +
                        "   text-size: 20;" +
                        "   text-color: blue;" +
                        "   text-style: bold;" +
                        "   text-alignment: along;" +
                        "   text-offset: 0px, 10px;" +
                        "   arrow-size: 20px, 10px;" +
                        "}");

        // 创建图形的视图器，设置为在另一个线程中显示图形
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout(); // 启用自动布局
        javax.swing.JFrame frame = new javax.swing.JFrame("GraphStream"); // 创建一个新的Swing窗口
        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE); // 设置默认关闭操作
        frame.setPreferredSize(new Dimension(1200, 800)); // 设置窗口的推荐大小
        javax.swing.JPanel panel = (javax.swing.JPanel) viewer.addDefaultView(false); // 将图形视图添加到Swing面板
        frame.add(panel); // 将面板添加到窗口
        frame.pack(); // 调整窗口大小以适应其内容
        frame.setVisible(true); // 显示窗口
    }
}
