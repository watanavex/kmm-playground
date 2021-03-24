import UIKit
import SharedApi

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        
        // Override point for customization after application launch.
        let apiClient = ApiClient()
        let iOSClient = IosClient(apiClient: apiClient)
        iOSClient.requestFlow(searchWord: "kotlin")
            .subscribe(
                scope: iOSClient.scope,
                onEach: { response in
                    print("onEach", response)
                },
                onComplete: {
                    print("onComplete")
                },
                onFailure: { error in
                    print("Failure👎", error)
                })
        
        iOSClient.request(searchWord: "swift")
            .subscribe(
                scope: iOSClient.scope,
                onSuccess: { response in
                    print("Success!!!", response)
                },
                onFailure: { error in
                    print("Failure👎", error)
                })
        AFClient.init().request(searchWord: "")
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

