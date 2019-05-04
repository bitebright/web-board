//
//  PostCommentCell.swift
//  Web-board
//
//  Created by Tawisit Rungsimuntupong on 3/5/2562 BE.
//  Copyright © 2562 Tawisit Rungsimuntupong. All rights reserved.
//

import UIKit

class PostCommentCell: UITableViewCell {

    @IBOutlet weak var content: UILabel!
    @IBOutlet weak var createDate: UILabel!
    @IBOutlet weak var createBy: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
