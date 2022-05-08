package com.mctlhg.mreview.service;

import com.mctlhg.mreview.dto.ReviewDTO;
import com.mctlhg.mreview.entity.Member;
import com.mctlhg.mreview.entity.Movie;
import com.mctlhg.mreview.entity.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getListOfMovie(Long mno); // 영화의 모든 영화리뷰를 가져온다.
    Long register(ReviewDTO movieReivewDTO); // 영화리뷰를 추가
    void modify(ReviewDTO movieReviewDTO); // 영화리뷰를 수정
    void remove(Long reviewnum); // 영화리뷰를 삭제

    default Review dtoToEntity(ReviewDTO movieReviewDTO){
        Review movieReview=Review.builder()
                .reviewnum(movieReviewDTO.getReviewnum())
                .movie(Movie.builder().mno(movieReviewDTO.getMno()).build())
                .member(Member.builder().mid(movieReviewDTO.getMid()).build())
                .grade(movieReviewDTO.getGrade())
                .text(movieReviewDTO.getText())
                .build();
        return movieReview;
    }
    default ReviewDTO entityToDto(Review movieReview){
        ReviewDTO movieReviewDTO=ReviewDTO.builder()
                .reviewnum(movieReview.getReviewnum())
                .mno(movieReview.getMovie().getMno())
                .mid(movieReview.getMember().getMid())
                .nickname(movieReview.getMember().getNickName())
                .email(movieReview.getMember().getEmail())
                .grade(movieReview.getGrade())
                .text(movieReview.getText())
                .regDate(movieReview.getRegDate())
                .modeDate(movieReview.getModDate())
                .build();
        return movieReviewDTO;
    }
}
