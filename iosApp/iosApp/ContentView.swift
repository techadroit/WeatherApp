import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel = KoinDependency.getHomeViewModel()
	let greet = Greeting().greet()

	var body: some View {
        Text("Hello Kmp")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
