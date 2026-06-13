//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Angel Angeles Molina on 18/05/26.
//

import SwiftUI
import ComposeApp

extension SourcesScreen {
    
    @MainActor
        class SourcesViewModelWrapper: ObservableObject {
            
            init() {
                viewModel = SourcesInjector().sourcesViewModel
                sourcesState = viewModel.sourcesState.value
            }
            
            let viewModel: SourcesViewModel
            
            @Published var sourcesState: SourcesState
            
            func startObserving() {
                Task {
                    for await sourcesS in viewModel.sourcesState {
                        self.sourcesState = sourcesS
                    }
                }
            }
        }
}

struct SourcesScreen: View {
    
    @Environment(\.dismiss)
        private var dismiss
        
        @ObservedObject private(set) var viewModel: SourcesScreen.SourcesViewModelWrapper
        
        var body: some View {
            NavigationStack {
                VStack {
                    
                    if let error = viewModel.sourcesState.isError {
                        ErrorMessage(message: error)
                    }
                    
                    if viewModel.sourcesState.isLoading {
                        Loader()
                    }
                    
                    if !viewModel.sourcesState.sources.isEmpty {
                        ScrollView {
                            LazyVStack(spacing: 10) {
                                ForEach(viewModel.sourcesState.sources, id: \.self) { source in
                                    SourceItemView(source: source)
                                }
                            }
                        }
                    }
                }.onAppear{
                    self.viewModel.startObserving()
                }
                .navigationTitle("Sources")
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                }
            }
        }

}

struct SourceItemView: View {
   
    var source : Source
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(source.name)
                .font(.title)
                .fontWeight(.bold)
            Text(source.desc)
            Text(source.countryLanguage).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}
