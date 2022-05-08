package com.mctlhg.mreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long reviewnum; // 리뷰 번호
    private Long mno;// 영화 번호
    private Long mid; // 멤버 id
    private String nickname; //멤버 별명
    private String email;// 멤버 email
    private int grade; // 평점
    private String text; // 리뷰 내용
    private LocalDateTime regDate, modeDate;
}
