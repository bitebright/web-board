//
//  CommonWorker.swift
//  Web-board
//
//  Created by Tawisit Rungsimuntupong on 2/5/2562 BE.
//  Copyright © 2562 Tawisit Rungsimuntupong. All rights reserved.
//

import Foundation

enum HttpMethod: String {
    case get = "GET"
    case post = "POST"
}

class CommonWorker {
    static let shared = CommonWorker()
    
    var baseUrl: String = "http://206.189.86.67:8080"
    let dateTimeFormatter = DateFormatter()
    let dateString = DateFormatter()
    
    init() {
        dateTimeFormatter.locale = Locale(identifier: "en_US_POSIX")
        dateTimeFormatter.timeZone = TimeZone(abbreviation: "UTC")
        dateTimeFormatter.dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
        
        dateString.locale = Locale(identifier: "en_US_POSIX")
        dateString.timeZone = TimeZone(abbreviation: "UTC")
        dateString.dateFormat = "dd-MM-yyyy"
    }
    
    func getIPAddress() -> String? {
        var address : String?
        
        // Get list of all interfaces on the local machine:
        var ifaddr : UnsafeMutablePointer<ifaddrs>?
        guard getifaddrs(&ifaddr) == 0 else { return nil }
        guard let firstAddr = ifaddr else { return nil }
        
        // For each interface ...
        for ifptr in sequence(first: firstAddr, next: { $0.pointee.ifa_next }) {
            let interface = ifptr.pointee
            
            // Check for IPv4 or IPv6 interface:
            let addrFamily = interface.ifa_addr.pointee.sa_family
            if addrFamily == UInt8(AF_INET) || addrFamily == UInt8(AF_INET6) {
                
                // Check interface name:
                let name = String(cString: interface.ifa_name)
                if  name == "en0" {
                    
                    // Convert interface address to a human readable string:
                    var hostname = [CChar](repeating: 0, count: Int(NI_MAXHOST))
                    getnameinfo(interface.ifa_addr, socklen_t(interface.ifa_addr.pointee.sa_len),
                                &hostname, socklen_t(hostname.count),
                                nil, socklen_t(0), NI_NUMERICHOST)
                    address = String(cString: hostname)
                }
            }
        }
        
        freeifaddrs(ifaddr)
        return address
    }
}
