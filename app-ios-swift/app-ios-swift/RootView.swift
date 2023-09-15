import SwiftUI
import shared

struct RootView: View {
    private let root: RootComponent

    init(_ root: RootComponent) {
        self.root = root
    }
    
    var body: some View {
        StackView(
            stackValue: StateValue(root.stack),
            getTitle: {
                switch $0 {
                case is RootComponentChild.Main: return "Decompose Template"
                case is RootComponentChild.Welcome: return "Welcome Screen"
                default: return ""
                }
            },
            onBack: root.onBackClicked
        ) {
            switch $0 {
            case let child as RootComponentChild.Main: MainView(child.component)
            case let child as RootComponentChild.Welcome: WelcomeView(child.component)
            default: EmptyView()
            }
        }
    }
}

struct RootView_Previews: PreviewProvider {
    static var previews: some View {
        RootView(PreviewRootComponent())
    }
}

class PreviewRootComponent : RootComponent {
    func onBackClicked(toIndex: Int32) {}

    var stack: Value<ChildStack<AnyObject, RootComponentChild>> = simpleChildStack(RootComponentChild.Main(component: PreviewMainComponent()))
}
