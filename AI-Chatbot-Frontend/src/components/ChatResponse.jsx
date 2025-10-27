const ChatResponse = ({response}) => {
    if(!response)
    {
        return null;
    }

    const {candidates, usageMetaData}=response;


    return(
        <div className="container my-4">
            <h3>Response</h3>
        {candidates.map((candidates,index)=> (
             <div className="card mb-3" key={index}>
            <div className="card-body">
            <h5 className="card-title">Candidate {index+1}</h5>
            <p className="card-text">{candidates.content.parts[0].text}</p>
            
            <ul>
                {candidates?.citationMetadata?.citationSources.map((source,idx)=>(
                    <li key={idx}>
                        <a href={source.url} target="blank"> 
                            {source.url}
                        </a>
                        (Indexes : {source.startIndex}-{source.endIndex})
                    </li>
                ))}
            </ul>
            </div>
        </div>
        ))}


   



        </div>
    )
}

export default ChatResponse;