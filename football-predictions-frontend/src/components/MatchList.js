
import React, { useEffect, useState } from "react";
import api from "../services/api";

const MatchList = () => {
  const [matches, setMatches] = useState([]);

  useEffect(() => {
    api.get("/fixtures")
      .then(response => setMatches(response.data))
      .catch(err => console.error("Error fetching matches:", err));
  }, []);

  return (
    <div>
      <h2>Upcoming Matches</h2>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {matches.map((match, index) => (
          <li key={index} style={{ margin: "10px 0" }}>
            <strong>{match.homeTeam}</strong> vs <strong>{match.awayTeam}</strong> - {match.date}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MatchList;
