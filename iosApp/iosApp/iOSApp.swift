import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init(){
        DependenciesiOSKt.doInitKoinIos()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
