CREATE TABLE IF NOT EXISTS todo (
  user_id INT,
  task_id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255),
  deadline DATE,
  priority INT DEFAULT 0,
  state_id INT DEFAULT 0
  );