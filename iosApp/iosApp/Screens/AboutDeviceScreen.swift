//
//  AboutDeviceScreen.swift
//  iosApp
//
//  Created by Innocent Mabuza on 2024/07/21.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutDeviceScreen: View {
    var body: some View {
        NavigationStack{
            AboutDeviceView().navigationTitle("About Device")
        }
    }
}

#Preview {
    AboutDeviceScreen()
}
