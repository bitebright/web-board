//
//  UIViewController.swift
//  Web-board
//
//  Created by Tawisit Rungsimuntupong on 3/5/2562 BE.
//  Copyright © 2562 Tawisit Rungsimuntupong. All rights reserved.
//

import UIKit

extension UIViewController: UIGestureRecognizerDelegate {}

extension UIViewController {
    @IBAction func back(_ sender: Any) {
        _ = navigationController?.popViewController(animated: true)
    }
}
