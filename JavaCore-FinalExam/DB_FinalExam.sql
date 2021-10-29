DROP DATABASE IF EXISTS DB_FinalExam;
CREATE DATABASE DB_FinalExam;
USE DB_FinalExam;

DROP TABLE IF EXISTS Candidate;
CREATE TABLE Candidate (
	CandidateID				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,
    Phone					VARCHAR(20),
    Email					VARCHAR(50) UNIQUE NOT NULL,
    `Password`				VARCHAR(200) NOT NULL,
    ExpInYear				SMALLINT UNSIGNED,
    ProSkill				NVARCHAR(100),
    GraduationRank			ENUM('EXCELLENCE', 'GOOD', 'FAIR', 'POOR'),
    Category				ENUM('EXPERIENCECANDIDATE', 'FRESHERCANDIDATE')
);

INSERT INTO Candidate (FirstName, LastName, Phone, Email, `Password`, ExpInYear, ProSkill, GraduationRank, Category)
VALUES (N'Vũ', N'Văn Bình', '0363004893', 'vubinh4893@gmail.com', 'Binh123456', 5, N'DEV', NULL, 'EXPERIENCECANDIDATE'),
		(N'Nguyễn', N'Minh Hiếu', '0981759146', 'hieucaka1999@gmail.com', 'Hieungungok99', NULL, NULL, 'EXCELLENCE', 'FRESHERCANDIDATE'),
        (N'Trần', N'Tuấn Phương', '0911090009', 'phuongluffy1999@gmail.com', 'Phuongvan123', '10', N'TEST', NULL, 'EXPERIENCECANDIDATE');