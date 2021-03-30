import UIKit
import SharedApi

class SearchWordProvider: SharedApi.SearchWordProvider {

    let word = "Alamofire"

}

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        
        ModuleKt.doInitKoin(searchWordProvider: SearchWordProvider())
        
        let iOSClient = IosClient()
        iOSClient.request()
            .subscribe(
                scope: iOSClient.iosScope,
                onSuccess: { response in
                    print("Success!!!", response)
                },
                onFailure: { error in
                    print("Failure👎", error)
                })


//        job.cancel(cause: Kotlinx_coroutines_coreCancellationException(message: "Cancel"))
        
        return true
    }

    // MARK: UISceneSession Lifecycle

    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        // Called when a new scene session is being created.
        // Use this method to select a configuration to create the new scene with.
        return UISceneConfiguration(name: "Default Configuration", sessionRole: connectingSceneSession.role)
    }

    func application(_ application: UIApplication, didDiscardSceneSessions sceneSessions: Set<UISceneSession>) {
        // Called when the user discards a scene session.
        // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
        // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
    }


}

