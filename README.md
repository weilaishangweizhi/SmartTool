# SmartTool
## Gradle应用
    implementation 'com.github.weilaishangweizhi:SmartTool:tag'
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
+ 数据库操作（db包）  
    db包内为ormlite数据库项目，CityCodeBean、CityCodeDao为事例。DBHelper为工具类  
    相关文章：https://blog.csdn.net/huangxiaoguo1/article/details/89180064  
    GitHub地址：https://github.com/j256/ormlite-android  

+ 自定义对话框（dialog包）
    + LoadingDialog 加载进度条  
    + TextViewDialog 简单文字提示对话框  
    + TimePickerDialog 系统时间选择对话框  
 
 + 自定义WebView（dsbridge）  
    三端易用的现代跨平台 Javascript bridge， 通过它，你可以在Javascript和原生之间同步或异步的调用彼此的函数  
    相关文章：https://github.com/wendux/DSBridge-Android/blob/master/readme-chs.md  

+ 工具类（utils包）  
    + ACache 存储数据工具类，可替代SharedPreferences  
    + CaiUtils 常规工具类  
    + CCM_DateTime 时间日期工具类  
    + FileUtils 文件工具类  
    + HexStringUtil 哈希编码工具类  
    + Mlog 自定日志  
+ 自定义View(views)  
    + MyLinearLayoutForListView 自定义LinearLayout,实现类似ListView功能，可动态添加子view  
    + ZPopupWindow 自定义弹出的PopupWindow  

## 第三方集成  
+ 屏幕适配  
    gradle集成：api 'me.jessyan:autosize:1.1.2'  
    相关文章：https://github.com/JessYanCoding/AndroidAutoSize  
+ Eventbus  
    gradle集成：'org.greenrobot:eventbus:3.1.1'   
    相关文章：https://github.com/JessYanCoding/AndroidAutoSize  
+ 大图banner  
    gradle集成：api 'cn.bingoogolapple:bga-banner:3.0.0@aar'  
    相关文章：https://github.com/bingoogolapple/BGABanner-Android  
+ 工具类utilcode  
    gradle集成：api 'com.blankj:utilcode:1.9.6'  
    相关文章：https://blankj.com/
+ 智能下拉刷新框架  
    gradle集成：  
        api  'com.scwang.smart:refresh-layout-kernel:2.0.1'      //核心必须依赖  
        api  'com.scwang.smart:refresh-header-classics:2.0.1'    //经典刷新头  
        api  'com.scwang.smart:refresh-footer-classics:2.0.1'    //经典加载  
        api  'com.scwang.smart:refresh-footer-ball:2.0.1'        //球脉冲加载  
        api  'com.scwang.smart:refresh-header-radar:2.0.1'       //雷达刷新头  
        api  'com.scwang.smart:refresh-header-falsify:2.0.1'     //虚拟刷新头  
        api  'com.scwang.smart:refresh-header-material:2.0.1'    //谷歌刷新头  
        api  'com.scwang.smart:refresh-header-two-level:2.0.1'   //二级刷新头  
      
    相关文章：https://github.com/scwang90/SmartRefreshLayout/  
+ 网络框架okGo  
    gradle集成：api 'com.lzy.net:okgo:3.0.4'  
    相关文章：https://github.com/jeasonlzy/okhttp-OkGo  


