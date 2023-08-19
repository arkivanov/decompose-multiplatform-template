import SwiftUI
import shared

struct RootView: View {
    private let root: RootComponent
    
    @StateValue
    private var model: RootComponentModel
    
    init(_ root: RootComponent) {
        self.root = root
        _model = StateValue(root.model)
    }
    
    var body: some View {
        VStack {
            Button(action: root.onUpdateGreetingText) {
                Text(model.greetingText)
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
    let model: Value<RootComponentModel> = mutableValue(
        RootComponentModel(greetingText: "Hello from Decompose!")
    )

    func onUpdateGreetingText() {}
}
