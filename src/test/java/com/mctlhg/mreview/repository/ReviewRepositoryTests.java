package com.mctlhg.mreview.repository;

import com.mctlhg.mreview.entity.Member;
import com.mctlhg.mreview.entity.Movie;
import com.mctlhg.mreview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMovieReviews(){
        IntStream.rangeClosed(1,200).forEach(i->{
            Long mno=(long)(Math.random()*100)+1; // 영화정보
            Long mid=(long)(Math.random()*100)+1; // review하는 사람 정보
            Member member=Member.builder().mid(mid).build();

            Review movieReview= Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("이 영화에 대한 느낌..."+i)
                    .build();
            reviewRepository.save(movieReview);
        });
    }
    @Test
    public void testGetMovieReviews(){
        Movie movie=Movie.builder().mno(77L).build();
        List<Review> result=reviewRepository.findByMovie(movie);

        result.forEach(mr->{
            System.out.print(mr.getReviewnum()+"\t");
            System.out.print(mr.getGrade()+"\t");
            System.out.print(mr.getText()+"\t");
            System.out.print(mr.getMember().getEmail());
            System.out.println("---------------------------------");
        });
    }
    @Test
    public void insertMovieReviewsInto101(){ //101번 영화에 4개의 리뷰를 넣는다.
        IntStream.rangeClosed(1,4).forEach(i->{
            Long mno=101L; // 영화정보
            Long mid=100L; // review하는 사람 정보
            Member member=Member.builder().mid(mid).build();

            Review movieReview= Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("AI닥터..."+i)
                    .build();
            reviewRepository.save(movieReview);
        });
    }
}
