package com.roytrack.mybatis.complexMap;

/**
 * a service to resolve complex resultmap in mybatis
 *
 * <resultMap id="detailedBlogResultMap" type="Blog">
 <constructor>
 <idArg column="blog_id" javaType="int"/>
 </constructor>
 <result property="title" column="blog_title"/>
 <association property="author" javaType="Author">
 <id property="id" column="author_id"/>
 <result property="username" column="author_username"/>
 <result property="password" column="author_password"/>
 <result property="email" column="author_email"/>
 <result property="bio" column="author_bio"/>
 <result property="favouriteSection" column="author_favourite_section"/>
 </association>
 <collection property="posts" ofType="Post">
 <id property="id" column="post_id"/>
 <result property="subject" column="post_subject"/>
 <association property="author" javaType="Author"/>
 <collection property="comments" ofType="Comment">
 <id property="id" column="comment_id"/>
 </collection>
 <collection property="tags" ofType="Tag" >
 <id property="id" column="tag_id"/>
 </collection>
 <discriminator javaType="int" column="draft">
 <case value="1" resultType="DraftPost"/>
 </discriminator>
 </collection>
 </resultMap>
 *
 *
 *   select
 B.id as blog_id,
 B.title as blog_title,
 B.author_id as blog_author_id,
 A.id as author_id,
 A.username as author_username,
 A.password as author_password,
 A.email as author_email,
 A.bio as author_bio,
 A.favourite_section as author_favourite_section,
 P.id as post_id,
 P.blog_id as post_blog_id,
 P.author_id as post_author_id,
 P.created_on as post_created_on,
 P.section as post_section,
 P.subject as post_subject,
 P.draft as draft,
 P.body as post_body,
 C.id as comment_id,
 C.post_id as comment_post_id,
 C.name as comment_name,
 C.comment as comment_text,
 T.id as tag_id,
 T.name as tag_name
 from Blog B
 left outer join Author A on B.author_id = A.id
 left outer join Post P on B.id = P.blog_id
 left outer join Comment C on P.id = C.post_id
 left outer join Post_Tag PT on PT.post_id = P.id
 left outer join Tag T on PT.tag_id = T.id
 where B.id = #{id}
 *
 * Created by roytrack on 2016-09-17.
 */
public class CpxService {
}
