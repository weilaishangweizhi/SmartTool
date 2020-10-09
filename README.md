# SmartTool
## Gradle应用
    implementation 'com.github.weilaishangweizhi:SmartTool:1.0.0'
## 功能介绍
+ CaiBaseActivity
    + 设置状态栏透明  
       >  @Override  
          public boolean setTranslucent() {  
             return false;  
          }  
         return true 设置状态栏透明  false 不设置  
         相关文章:https://blog.csdn.net/u014418171/article/details/81223681
    + 初始化滑动返回  
       > 必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回  
            public class App extends Application {

                @Override
                public void onCreate() {
                    super.onCreate();

                    /**
                     * 必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回
                     * 第一个参数：应用程序上下文
                     * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，请把该界面里比较特殊的 View 的 class 添加到该集合中，目前在库中已经添加了 WebView 和 SurfaceView
                     */
                    BGASwipeBackHelper.init(this, null);
                }
            }  
            
            相关文章：https://github.com/bingoogolapple/BGASwipeBackLayout-Android
    
    + activity转场动画设置
