
CREATE TABLE `participant` (
  `participant_uuid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `last_seen` datetime NOT NULL,
  PRIMARY KEY (`participant_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

Alter table pending_message auto_increment=1000;
Alter table participant auto_increment=3000;

CREATE TABLE pending_message (
    message_uuid int NOT NULL AUTO_INCREMENT ,
    message_type int,
    message varchar(500), 
    participant_uuid int NOT NULL,
    PRIMARY KEY (message_uuid),
    FOREIGN KEY (participant_uuid) REFERENCES participant(participant_uuid)
);

