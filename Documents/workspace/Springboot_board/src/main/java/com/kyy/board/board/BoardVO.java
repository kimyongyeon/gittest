package com.kyy.board.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by yongyeonkim on 2016. 8. 16..
 */
@Entity
@Table(name = "tb_board")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bno;
    private String title;
    private String content;
}
