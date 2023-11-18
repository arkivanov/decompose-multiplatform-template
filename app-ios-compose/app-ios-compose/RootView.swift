import SwiftUI
import shared

struct RootView: UIViewControllerRepresentable {
    let root: RootComponent
    
    func makeUIViewController(context: Context) -> UIViewController {
        let controller = RootViewControllerKt.rootViewController(root: root)
        controller.overrideUserInterfaceStyle = .light
        return controller
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}
