# SmartTool
## Gradle应用
    implementation 'com.github.weilaishangweizhi:SmartTool:1.0.0'
## 功能介绍
+ CaiBaseActivity
    + 设置状态栏透明  

          @Override  
          public boolean setTranslucent() {  
                return false;  
          }  
            
         return true 设置状态栏透明  false 不设置  
         相关文章:https://blog.csdn.net/u014418171/article/details/81223681
    + 初始化滑动返回  
      必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回  
            
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
        例：  
    
          Intent intent = new Intent(mContext, TestActivity.class);
          intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_SHANG);
          startActivity(intent);
          
          public final static String ANIM_TYPE = "animType";
          public final static int ANIM_TYPE_SHANG = 1; //上进 上出
          public final static int ANIM_TYPE_XIA = 2;   //下进 下出
          public final static int ANIM_TYPE_LEFT = 3;  //左进 左出
          public final static int ANIM_TYPE_RIGHT = 4; //右进 右出
          public final static int ANIM_TYPE_SUOFANG = 5; //放大进 缩小出
          public final static int ANIM_TYPE_LONG_LEFT = 6; //左进 左出 350毫秒
          public final static int ANIM_TYPE_LONG_RIGHT = 7; //右进 右出 350毫秒
          
      
       
