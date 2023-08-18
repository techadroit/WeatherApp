import SwiftUI
import shared
import KMPNativeCoroutinesAsync

struct ContentView: View {
    
    @StateObject var homeViewModel = KoinDependency.shared.getHomeViewModel()
    @State var temp: Double = 0.0
    @State var cityName: String = ""

	var body: some View {
        HelloView(temp: temp,cityName: cityName)
            .onAppear{
                    Task.init(operation: {
                        let stream = asyncSequence(for: homeViewModel.stateFlowFlow)
                        
                        for try await state in stream {
                            let homeViewState = state as? HomeViewState
                            temp = homeViewState?.currentWeather?.temp ?? 0.0
                            cityName = "Mumbai"
                        }
                    })
                }
    }
}

struct HelloView: View{
    var temp : Double
    var cityName:String
    
    var body: some View{
        Text("Hello \(cityName) \(temp)")
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

class HomeObservable : ObservableObject{
    
    
    @Published var temp: Double = 0.0
    
    init() {
        load()
    }
    
    func load(){
        Task.init(operation: {
            let viewModel: HomeViewModel = KoinDependency.shared.getHomeViewModel()
            let stream = asyncSequence(for: viewModel.stateFlowFlow)
            
            for try await state in stream {
                let homeViewState = state as? HomeViewState
                temp = homeViewState?.currentWeather?.temp ?? 0.0
            }
        })
    }
    
}
