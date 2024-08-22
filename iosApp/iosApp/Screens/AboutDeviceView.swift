//
//  AboutDeviceView.swift
//  iosApp
//
//  Created by Innocent Mabuza on 2024/07/21.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutDeviceView: View {
    private struct RowItem: Hashable{
        let title: String
        let subtitle: String
    }
    
    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()
        
        var result: [RowItem] = [
            .init(title: "Operating System", subtitle: "\(platform.osName) \(platform.osVersion)"),
            .init(title: "Device", subtitle: platform.deviceModel),
            .init(title: "Density", subtitle: "@\(platform.density)x")
        ]
        return result
    }()
    
    var body: some View {
        List {
            ForEach(items, id: \.self){
                item in VStack(alignment: .leading){
                    Text(item.title).font(.footnote).foregroundStyle(.secondary)
                    Text(item.subtitle).font(.body).foregroundStyle(.primary)
                }.padding(.vertical, 4)
            }
        }
    }
}
