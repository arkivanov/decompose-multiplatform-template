import SwiftUI
import shared

struct WelcomeView: View {
    private let component: WelcomeComponent
    
    @StateValue
    private var model: WelcomeComponentModel
    
    init(_ component: WelcomeComponent) {
        self.component = component
        _model = StateValue(component.model)
    }
    
    var body: some View {
        VStack {
            Button(action: component.onUpdateGreetingText) {
                Text(model.greetingText)
            }
        }
        .navigationBarTitle("Welcome Screen", displayMode: .inline)
    }
}

struct WelcomeView_Previews: PreviewProvider {
    static var previews: some View {
        WelcomeView(PreviewWelcomeComponent())
    }
}

class PreviewWelcomeComponent : WelcomeComponent {
    let model: Value<WelcomeComponentModel> = mutableValue(
        WelcomeComponentModel(greetingText: "Hello from Decompose!")
    )

    func onUpdateGreetingText() {}
    func onBackClicked() {}
}
