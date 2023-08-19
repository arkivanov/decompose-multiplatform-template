import SwiftUI
import shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
        var appDelegate: AppDelegate

        private var rootHolder: RootHolder { appDelegate.getRootHolder() }
        
        var body: some Scene {
            WindowGroup {
                RootView(rootHolder.root)
                    .onReceive(NotificationCenter.default.publisher(for: UIApplication.didBecomeActiveNotification)) { _ in
                        LifecycleRegistryExtKt.resume(rootHolder.lifecycle)
                    }
                    .onReceive(NotificationCenter.default.publisher(for: UIApplication.willResignActiveNotification)) { _ in
                        LifecycleRegistryExtKt.pause(rootHolder.lifecycle)
                    }
                    .onReceive(NotificationCenter.default.publisher(for: UIApplication.didEnterBackgroundNotification)) { _ in
                        LifecycleRegistryExtKt.stop(rootHolder.lifecycle)
                    }
                    .onReceive(NotificationCenter.default.publisher(for: UIApplication.willTerminateNotification)) { _ in
                        LifecycleRegistryExtKt.destroy(rootHolder.lifecycle)
                    }
            }
        }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    private var rootHolder: RootHolder?
    
    func application(_ application: UIApplication, shouldSaveSecureApplicationState coder: NSCoder) -> Bool {
        return false
    }
    
    func application(_ application: UIApplication, shouldRestoreSecureApplicationState coder: NSCoder) -> Bool {
        return false
    }
    
    fileprivate func getRootHolder() -> RootHolder {
        if (rootHolder == nil) {
            rootHolder = RootHolder(savedState: nil)
        }
        
        return rootHolder!
    }
}

private class RootHolder {
    let lifecycle: LifecycleRegistry
    let root: RootComponent
    
    init(savedState: ParcelableParcelableContainer?) {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        
        root = DefaultRootComponent(
            componentContext: DefaultComponentContext(
                lifecycle: lifecycle,
                stateKeeper: nil,
                instanceKeeper: nil,
                backHandler: nil
            )
        )
        
        LifecycleRegistryExtKt.create(lifecycle)
    }
}
