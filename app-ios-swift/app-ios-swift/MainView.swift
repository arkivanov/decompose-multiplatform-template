import SwiftUI
import shared

struct MainView: View {
    private let component: MainComponent
    
    init(_ component: MainComponent) {
        self.component = component
    }
    
    var body: some View {
        VStack {
            Button(action: component.onShowWelcomeClicked) {
                Text("Show Welcome screen")
            }
        }
        .navigationBarTitle("Decompose Template", displayMode: .inline)
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView(PreviewMainComponent())
    }
}

class PreviewMainComponent : MainComponent {
    func onShowWelcomeClicked() {}
}
