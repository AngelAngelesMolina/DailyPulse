//
//  AboutScreen.swift
//  iosApp
//
//  Created by Angel Angeles Molina on 15/05/26.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle(Text("About Device"))
        }
    }
}

#Preview {
    AboutScreen()
}
