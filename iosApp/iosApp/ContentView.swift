import SwiftUI
import shared

let api = ApiUtility()

let repo = Repository(apiUtility: api)

struct ContentView: View {

        var body: some View {
            
            
        Text("Download Posts").padding()
                .onTapGesture {
                    repo.getFlowPosts().collect { value in
                       print(value!)
                    }
                }
            
            Text("Avinash").onTapGesture {
                repo.getPosts()
            }
            
            Text("Stop Job").onTapGesture {
                repo.stopPostJob()
            }
	}
    

}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		PostsView()
        
	}
}


struct PostsView : View{
    
    @State var posts = [Post]()

    var body: some View{
        
        Text("Download Posts").onTapGesture {
            repo.getPosts().collect { nsArray in
                posts = nsArray!.compactMap({ $0 as? Post })
            }
        }
        
        List(posts, id: \.id){ post in
          Text(post.title)
        }
    }
}
